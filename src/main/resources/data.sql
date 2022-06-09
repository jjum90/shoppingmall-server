INSERT INTO MEMBER (MEMBER_ID, CREATED_DATE, NAME) VALUES(1, '2022-06-08T11:58:20.551705', '홍길동');

INSERT INTO COUPON(COUPON_ID, CREATED_DATE, DISCOUNT_RATE, REFERENCE_PRICE, USE_STATUS, MEMBER_ID) VALUES(1, '2022-06-08T11:58:20.551705', '0.05', 10000, 'UNUSED', 1);
INSERT INTO COUPON(COUPON_ID, CREATED_DATE, DISCOUNT_RATE, REFERENCE_PRICE, USE_STATUS, MEMBER_ID) VALUES(2, '2022-06-08T11:58:20.551705', '0.1', 20000, 'UNUSED', 1);
INSERT INTO COUPON(COUPON_ID, CREATED_DATE, DISCOUNT_RATE, REFERENCE_PRICE, USE_STATUS, MEMBER_ID) VALUES(3, '2022-06-08T11:58:20.551705', '0.2', 30000, 'UNUSED', 1);

INSERT INTO MILEAGE (MILEAGE_ID, BALANCE, MEMBER_ID) VALUES(1, 4000, 1);

INSERT INTO POINT (POINT_ID, CREATED_DATE, BALANCE, EXPIRY_DATE, MEMBER_ID) VALUES(1, '2022-06-08T11:58:20.551705', 3000, '2022-06-30T11:58:20.551705', 1);
INSERT INTO POINT (POINT_ID, CREATED_DATE, BALANCE, EXPIRY_DATE, MEMBER_ID) VALUES(2, '2022-06-08T11:58:20.551705', 4000, '2022-06-29T11:58:20.551705', 1);
INSERT INTO POINT (POINT_ID, CREATED_DATE, BALANCE, EXPIRY_DATE, MEMBER_ID) VALUES(3, '2022-06-08T11:58:20.551705', 5000, '2022-06-28T11:58:20.551705', 1);

INSERT INTO PRODUCT (PRODUCT_ID, CREATED_DATE, NAME, PRICE ) VALUES(1, '2022-06-08T11:58:20.551705', '티셔츠', 33000);
INSERT INTO PRODUCT (PRODUCT_ID, CREATED_DATE, NAME, PRICE ) VALUES(2, '2022-06-08T11:58:20.551705', '바지' , 250000);
INSERT INTO PRODUCT (PRODUCT_ID, CREATED_DATE, NAME, PRICE ) VALUES(3, '2022-06-08T11:58:20.551705', '신발', 110000);
INSERT INTO PRODUCT (PRODUCT_ID, CREATED_DATE, NAME, PRICE ) VALUES(4, '2022-06-08T11:58:20.551705', '자켓', 550000);
INSERT INTO PRODUCT (PRODUCT_ID, CREATED_DATE, NAME, PRICE ) VALUES(5, '2022-06-08T11:58:20.551705', '패딩', 1100000);
INSERT INTO PRODUCT (PRODUCT_ID, CREATED_DATE, NAME, PRICE ) VALUES(6, '2022-06-08T11:58:20.551705', '정장 세트', 1500000);
INSERT INTO PRODUCT (PRODUCT_ID, CREATED_DATE, NAME, PRICE ) VALUES(7, '2022-06-08T11:58:20.551705', '구두',1000000);