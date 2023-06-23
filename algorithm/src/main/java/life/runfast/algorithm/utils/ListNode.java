package life.runfast.algorithm.utils;

/**
 * @author justatempa
 * @description
 * @datetime 2023/6/21 12:55
 */
public class ListNode <T> {

    private T data;
    private ListNode<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public ListNode() {}

    public static ListNode<Integer> generateInt(int i) {
        ListNode<Integer> root = new ListNode<>(1, null);
        ListNode<Integer> cur = root;
        for (int j = 2; j <= i; j++) {
            ListNode<Integer> node = new ListNode<>(j, null);
            cur.setNext(node);
            cur = node;
        }
        return root;
    }

    public static void print(ListNode root) {
        while(root != null) {
            System.out.print(root.getData());
            System.out.print(" ");
            root = root.getNext();
        }
        System.out.println();
    }
}
