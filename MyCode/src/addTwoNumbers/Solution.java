package addTwoNumbers;

import java.util.LinkedList;

public class Solution {
    public Solution(){
        addTwoNumbers(numberToListNode(832), numberToListNode(921));
//        addTwoNumbers(numberToListNode(5649), numberToListNode(249));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=null;
        int l1Size=size(l1);
        int l2Size=size(l2);
        if(l1Size>=l2Size){
            result=add(l1,l2);
        }
        else {
            result=add(l2,l1);
        }
        return result;
    }

    private ListNode add(ListNode l1, ListNode l2){
        var head=l1;
        int transfer=0;//перенос в старший разряд
        while (l1.next!=null && l2.next!=null){
            l1.val+=l2.val+transfer;
            transfer=0;
            if(l1.val>9){
                transfer=l1.val/10;
                l1.val=l1.val%10;
            }
            l1=l1.next;
            l2=l2.next;
        }
        l1.val+=l2.val+transfer;
        if(l1.val>9){
            transfer=l1.val/10;
            l1.val=l1.val%10;
            if(l1.next==null){
                l1.next=new ListNode(transfer);
            }
            else{
                l1=l1.next;
                while (l1.next!=null && transfer>0){
                    l1.val=l1.val+transfer;
                    transfer=0;
                    if(l1.val>9){
                        transfer=l1.val/10;
                        l1.val=l1.val%10;
                    }
                    l1=l1.next;
                }
                l1.val=l1.val+transfer;
                if(l1.val>9){
                    transfer=l1.val/10;
                    l1.val=l1.val%10;
                    l1.next=new ListNode(transfer);
                }
            }
        }
        return head;
    }

    private ListNode numberToListNode(int number) {
        ListNode head = null;
        if (number >= 10) {
            var stack = new LinkedList<Integer>();
            while (number >= 10) {
                stack.addFirst(number % 10);
                number /= 10;
            }
            stack.addFirst(number);
            head = new ListNode(stack.pollLast());
            while (!stack.isEmpty()) {
                var node=new ListNode(stack.pollLast(),head);
                head=node;
            }
        } else {
            head=new ListNode(number);
        }
        return head;
    }

    private int size(ListNode l){
        int size=0;
        while(l!=null){
            size++;
            l=l.next;
        }
        return size;
    }

}




