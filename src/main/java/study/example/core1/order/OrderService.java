package study.example.core1.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemname, int itemprice);
}

