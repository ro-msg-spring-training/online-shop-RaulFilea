ALTER TABLE `product`
    ADD FOREIGN KEY (category) REFERENCES product_category(id);

ALTER TABLE `product`
    ADD FOREIGN KEY (supplier) REFERENCES supplier(id);

ALTER TABLE `stock`
    ADD FOREIGN KEY (product) REFERENCES product(id);

ALTER TABLE `stock`
    ADD FOREIGN KEY (location) REFERENCES location(id);

ALTER TABLE `orders`
    ADD FOREIGN KEY (shipped_from) REFERENCES location(id);

ALTER TABLE `orders`
    ADD FOREIGN KEY (customer) REFERENCES customer(id);

ALTER TABLE `order_detail`
    ADD FOREIGN KEY (thisorder) REFERENCES orders(id);

ALTER TABLE `order_detail`
    ADD FOREIGN KEY (product) REFERENCES product(id);