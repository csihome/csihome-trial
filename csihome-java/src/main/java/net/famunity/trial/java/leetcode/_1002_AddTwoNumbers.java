package net.famunity.trial.java.leetcode;

import java.util.Stack;

/*
   (2->4->1) + (5->6->4) = (7->0->6)
 */
public class _1002_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1e1 = new ListNode(2);
        ListNode l1e2 = new ListNode(4);
        ListNode l1e3 = new ListNode(1);
        l1e1.next = l1e2;
        l1e2.next = l1e3;
        System.out.println(l1e1.val + "->" + l1e1.next.val + "->" + l1e1.next.next.val);

        ListNode l2e1 = new ListNode(5);
        ListNode l2e2 = new ListNode(7);
        ListNode l2e3 = new ListNode(4);
        l2e1.next = l2e2;
        l2e2.next = l2e3;
        System.out.println(l2e1.val + "->" + l2e1.next.val + "->" + l2e1.next.next.val);

        ListNode result1 = addTwoNumbersReverse(l1e1, l2e1);

        System.out.println(result1.val + "->" + result1.next.val + "->" + result1.next.next.val);


        ListNode result2 = addTwoNumbersNonReverse(l1e1, l2e1);

        System.out.println(result2.val + "->" + result2.next.val + "->" + result2.next.next.val);
    }

    public static ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
        ListNode sumNode = new ListNode(0);

        ListNode l1c = l1, l2c = l2, current = sumNode;
        int carry = 0;

        while(l1c != null || l2c != null){
            int l1cv = (l1c != null) ? l1c.val : 0;
            int l2cv = (l2c != null) ? l2c.val : 0;
            int sum = carry + l1cv + l2cv;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1c != null) l1c = l1c.next;
            if (l2c != null) l2c = l2c.next;
        }

        if(carry > 0){
            current.next = new ListNode(carry);
        }

        return sumNode.next;
    }

    public static ListNode addTwoNumbersNonReverse(ListNode l1, ListNode l2) {

        Stack<Integer> l1s = new Stack<>(), l2s = new Stack<>();
        while (l1 != null) {
            l1s.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2s.push(l2.val);
            l2 = l2.next;
        }

        ListNode sumNode = null, current = null;

        int sum=0;

        while (!l1s.empty() || !l2s.empty()){
            sum /= 10; // This is carry value from previous node summary

            if(!l1s.empty()){
                sum += l1s.pop();
            }
            if(!l2s.empty()){
                sum += l2s.pop();
            }

            current = new ListNode(sum % 10);
            current.next = sumNode; // right first node has no next, it's null.
            sumNode = current; // sum will get value, once right first node calculation.
        }

        if(sum >= 10){
            current = new ListNode(sum / 10);
            current.next = sumNode;
        }

        return current;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}
