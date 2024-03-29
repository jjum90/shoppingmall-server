package com.daou.shoppingmall.service.impl;

import com.daou.shoppingmall.dto.OrderDto;
import com.daou.shoppingmall.dto.ProductDto;
import com.daou.shoppingmall.dto.PurchaseDto;
import com.daou.shoppingmall.entity.Order;
import com.daou.shoppingmall.entity.OrderProduct;
import com.daou.shoppingmall.entity.Product;
import com.daou.shoppingmall.repository.OrderRepository;
import com.daou.shoppingmall.service.OrderService;
import com.daou.shoppingmall.service.OrderWrapperService;
import com.daou.shoppingmall.utils.PayType;
import lombok.RequiredArgsConstructor;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * OrderWrapperServiceImpl
 *
 * @author : 정민석
 * @version : v1.0
 * @class 설명 : 주문, 결제 관리 Wrapper 서비스
 * @작성일 : 2022-08-24
**/
@Service
@RequiredArgsConstructor
public class OrderWrapperServiceImpl implements OrderWrapperService {
    private final Map<String, OrderService> serviceMap;
    private final OrderRepository orderRepository;

    /**
     * 결제 타입에 따라 구현 서비스를 제공
     * @param purchaseDto
     * @return OrderService
     */
    public OrderService getPurchaseServiceOf(PurchaseDto purchaseDto) {
        PayType payType = PayType.fromType(purchaseDto.getPayType());
        Class<? extends OrderService> serviceType = payType.getServiceType();
        String beanName = serviceType.getSimpleName();
        beanName = beanName.substring(0, 1).toLowerCase().concat(beanName.substring(1));
        Service serviceAnnotation = serviceType.getAnnotation(Service.class);
        if (serviceAnnotation != null && !StringUtils.isBlank(serviceAnnotation.value())) {
            beanName = serviceAnnotation.value();
        }
        OrderService service = this.serviceMap.get(beanName);
        if (service == null) {
            throw new IllegalArgumentException("Cannot find the service.");
        }
        return service;
    }

    /**
     * 환불
     * @param orderId
     * @return
     */
    public OrderService getRefundServiceOf(String orderId) {
        Optional<Order> optOrder = orderRepository.findById(Long.valueOf(orderId));

        if(!optOrder.isPresent()) {
            throw new IllegalStateException("Not found order by " + orderId);
        }
        Order order = optOrder.get();

        return null;
    }

    /**
     * 주문 및 주문 상품 정보를 제공
     * @return
     */
    public List<OrderDto> getOrders() {
        Page<Order> pageOrder = orderRepository.findAll(PageRequest.of(0, 20));

        List<OrderDto> orders = pageOrder.stream().map((Order order) -> {
            List<OrderProduct> orderProducts = order.getOrderProduct();
            List<ProductDto> products = orderProducts.stream().map((OrderProduct orderProduct) -> {
                Product product = orderProduct.getProduct();
                return ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .selectQuantity(orderProduct.getCount())
                        .build();
            }).collect(Collectors.toList());

            return OrderDto.builder()
                    .id(order.getId())
                    .amount(order.getPayment())
                    .products(products)
                    .build();
        }).collect(Collectors.toList());

        return orders;
    }
}
