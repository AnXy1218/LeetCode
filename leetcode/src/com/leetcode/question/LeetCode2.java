package com.leetcode.question;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }

        int val1 = 0,val2 = 0;
        if(l1 != null){
            val1 = l1.val;
        }
        if(l2 != null){
            val2 = l2.val;
        }

        int sum = val1+val2;
        if(sum > 9){
            l2.val = sum%10;
            if(l2.next == null){
                l2.next = new ListNode(0);
            }
            l2.next.val += 1;
        }else{
            if(l2 != null){
                l2.val = sum;
            }
        }

        ListNode lTemp1 = l1 != null?l1.next:null;
        ListNode lTemp2 = l2 != null?l2.next:null;

        if(lTemp1 != null && lTemp2 == null){
            lTemp2 = lTemp1;
            lTemp1 = null;
        }
        if(l2 != null){
            l2.next = addTwoNumbers(lTemp1,lTemp2);
        }

        return l2;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
