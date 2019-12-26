package com.leetcode.question;

public class LeetCode21 {
    public static void main(String... args){
        ListNode list1 = new ListNode(2);
//        list1.next = new ListNode(2);
//        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
//        list2.next = new ListNode(3);
//        list2.next.next = new ListNode(4);

        ListNode result  = mergeTwoLists(list1,list2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tNode = l1;
        if(l1.val > l2.val){
            tNode = l2;
            l2 = l1;
            l1 = tNode;
        }

        tNode = l1;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                if(l1.next == null){
                    l1.next = l2;
                    l2 = null;
                } else if (l1.next.val >= l2.val){
                    System.out.println("------------1");
                    ListNode node = new ListNode(l2.val);
                    node.next = l1.next;
                    l1.next = node;
//                    l1.next.next = node;
//                    l1.next.val = l2.val;
                    l1 = l1.next;
                    l2 = l2.next;
                }else{
                    System.out.println("------------2");
                    l1 = l1.next;
                }
            }else{
                System.out.println("------------3");
                ListNode listNode = l2;
                l2 = l1;
                l1 = listNode;
            }
        }

        return tNode;
    }
}
