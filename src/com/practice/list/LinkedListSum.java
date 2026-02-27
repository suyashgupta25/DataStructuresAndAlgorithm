package com.practice.list;

import java.util.ArrayList;
import java.util.List;

public class LinkedListSum {

    public static void main(String[] args) {
        ListNode l = new ListNode(9);

        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);

        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;

        addTwoNumbers(l, l0);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = 0;
        long num2 = 0;
        ListNode node = l1;
        int pow = 0;
        while (node != null) {
            num1 = num1 + node.val * (long) Math.pow(10, pow);
            node = node.next;
            pow++;
        }
        node = l2;
        pow = 0;
        while (node != null) {
            num2 = num2 + node.val * (long) Math.pow(10, pow);
            node = node.next;
            pow++;
        }
        long num = num1 + num2;

        List<ListNode> list = new ArrayList<>();
        long quotient = -1;
        while (quotient != 0) {
            quotient = num / 10;
            long remainder = num % 10;
            if (list.isEmpty()) {
                ListNode l3 = new ListNode((int)remainder);
                list.add(l3);
            } else {
                ListNode listNode1 = list.get(list.size() - 1);
                listNode1.next = new ListNode((int)remainder);
                list.add(listNode1.next);
            }
            num = quotient;
        }
        return list.get(0);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
