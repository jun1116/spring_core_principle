package hello.core.order;

public interface OrderService {
    // OrderService에 주문 최종 결과 반납해야함
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
