/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
//use recursion
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode newhead; //new ListNode newhead; 是错的
        if(l1.val < l2.val){//注意要用.val比较大小
            newhead = l1;
            newhead.next = mergeTwoLists(l1.next, l2);
        }else{
            newhead = l2;
            newhead.next = mergeTwoLists(l1, l2.next);
        }
        return newhead;//这里return的是recursion 最外层的newhead，也就是第一个head
    }
}

// iteration
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode p = head;
 
    while(l1!=null||l2!=null){
        if(l1!=null&&l2!=null){
            if(l1.val < l2.val){
                p.next = l1;
                l1=l1.next;
            }else{
                p.next=l2;
                l2=l2.next;
            }
            p = p.next;
        }else if(l1==null){
            p.next = l2;
            break;
        }else if(l2==null){
            p.next = l1;
            break;
        }
    }
 
    return head.next;
}
