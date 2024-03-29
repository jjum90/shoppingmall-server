package com.daou.shoppingmall.entity;

import com.daou.shoppingmall.utils.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class PointHistory extends BaseEntity {
    @Id
    @SequenceGenerator(name = "point_history_id_sequence", sequenceName = "point_history_id_sequence", initialValue = 1, allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_history_id_sequence")
    @Column(name = "POINT_HIS_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POINT_ID")
    private Point point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private BigDecimal usePoint;

    public static PointHistory save(Point point, Money disCountAmount) {
        return PointHistory.builder()
                .usePoint(disCountAmount.getAmount())
                .createdDate(LocalDateTime.now())
                .point(point)
                .build();
    }

}
