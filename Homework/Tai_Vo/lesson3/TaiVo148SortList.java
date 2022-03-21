package lesson3;

/**
 * @author taivt
 * @link https://leetcode.com/problems/sort-list/
 * @since 2022/03/21 22:42:33
 */
public class TaiVo148SortList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode head = new Solution().sortList(node1);
        System.out.println("After sorted: ");
        Solution.print(head);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode mid = findMid(head);
            ListNode nextMid = mid.next;
            mid.next = null;

            System.out.println("=================================");
            System.out.println("left: " + head.val);
            System.out.println("mid: " + mid.val);
            System.out.println("right: " + nextMid.val);
            System.out.println("=================================");
            System.out.println("Left part before merge: ");
            print(head);
            System.out.println("Right part before merge: ");
            print(nextMid);

            ListNode left = sortList(head);
            ListNode right = sortList(nextMid);

            ListNode newHead = merge(left, right);
            System.out.println("New merged linked list: ");
            print(newHead);
            return newHead;
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode head = left.val <= right.val ? left : right;
            ListNode leftIter = left;
            ListNode rightIter = right;
            while (leftIter != null && rightIter != null) {
                if (leftIter.val <= rightIter.val) {
                    if (leftIter.next != null && leftIter.next.val <= rightIter.val) {
                        leftIter = leftIter.next;
                        continue;
                    }
                    ListNode nextLeft = leftIter.next;
                    leftIter.next = rightIter;
                    leftIter = nextLeft;
                } else {
                    if (rightIter.next != null && rightIter.next.val < leftIter.val) {
                        rightIter = rightIter.next;
                        continue;
                    }
                    ListNode nextRight = rightIter.next;
                    rightIter.next = leftIter;
                    rightIter = nextRight;
                }
            }
            return head;
        }


        private ListNode findMid(ListNode head) {
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        static void print(ListNode head) {
            ListNode iterator = head;
            while (iterator != null) {
                System.out.printf("%d ", iterator.val);
                iterator = iterator.next;
            }
            System.out.println();
        }
    }
}
