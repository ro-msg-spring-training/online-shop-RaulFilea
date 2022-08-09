ALTER TABLE `product`
    ADD CONSTRAINT FK_product_from_product_category FOREIGN KEY (category_id) REFERENCES product_category(id);

ALTER TABLE `product`
    ADD CONSTRAINT FK_product_from_supplier FOREIGN KEY (supplier_id) REFERENCES supplier(id);

ALTER TABLE `stock`
    ADD CONSTRAINT FK_stock_from_product FOREIGN KEY (product_id) REFERENCES product(id);

ALTER TABLE `stock`
    ADD CONSTRAINT FK_stock_from_location FOREIGN KEY (location_id) REFERENCES location(id);

ALTER TABLE `orders`
    ADD CONSTRAINT FK_orders_from_location FOREIGN KEY (shipped_from_id) REFERENCES location(id);

ALTER TABLE `orders`
    ADD CONSTRAINT FK_orders_from_customer FOREIGN KEY (customer_id) REFERENCES customer(id);

ALTER TABLE `order_detail`
    ADD CONSTRAINT FK_order_detail_from_orders FOREIGN KEY (thisorder_id) REFERENCES orders(id);

ALTER TABLE `order_detail`
    ADD CONSTRAINT FK_order_detail_from_product FOREIGN KEY (product_id) REFERENCES product(id);