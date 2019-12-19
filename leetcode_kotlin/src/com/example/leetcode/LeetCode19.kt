package com.example.leetcode

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
fun main(args:Array<String>){
    var node:ListNode = ListNode(5)

}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var i:Int = 1
    var temp:ListNode? = head
    while (temp!!.next != null){
        i++
        temp = temp!!.next
    }

    var deleteIndex = i-n

    if (deleteIndex < 1){
        return head
    }
    i = 1
    var nodeCurr:ListNode? = head
    var nodePre:ListNode? = null
    while (i < deleteIndex){
        i++
        nodePre = nodeCurr
        nodeCurr = nodeCurr!!.next
    }

    if (nodePre == null){
        nodeCurr = nodeCurr!!.next
        return nodeCurr
    }else{
        nodePre.next = nodeCurr!!.next
        return  head
    }
}