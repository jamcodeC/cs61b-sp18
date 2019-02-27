import com.sun.source.tree.WhileLoopTree;

import java.time.temporal.WeekFields;

public class LinkedListDeque<Welldone> {

    /**declarations */
    public StaffNode sentinel;
    public int size;

    /**basic staff node*/
    public class StaffNode{
        public Welldone item;
        public StaffNode prev;
        public StaffNode next;
        public StaffNode(Welldone i, StaffNode p, StaffNode n){
            item = i;
            prev = p;
            next = n;
        }
    }

    /**constructor*/

    public LinkedListDeque(){
        sentinel = new StaffNode(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(Welldone x){
        sentinel = new StaffNode(null,null,null);
        sentinel.next =  new StaffNode(x, sentinel,sentinel.prev);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /**methods*/

    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }

    public void printDeque(){
        StaffNode node = sentinel.next;
        while(node.next!=sentinel){
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.print(node.item);
        System.out.print("\n");
    }

    public int size(){
        return size;
    }

    public void addFirst(Welldone x){
        sentinel.next = new StaffNode(x,sentinel,sentinel.next); //link new with sentinel and old first one.
        sentinel.next.next.prev =sentinel.next;//link old first on with new first one.
        size += 1;
    }

    public void addLast(Welldone x){
        sentinel.prev = new StaffNode(x,sentinel.prev,sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }
    public Welldone removeFirst(){
        if(size==0) return null;
        Welldone item_return = sentinel.next.item;
        this.sentinel.next = this.sentinel.next.next;
        this.sentinel.next.prev = sentinel;
        size -= 1;
        return item_return;
    }
    public Welldone removeLast(){
        if(size==0) return null;
        Welldone item_return = sentinel.prev.item;
        this.sentinel.prev = this.sentinel.prev.prev;
        this.sentinel.prev.next = sentinel;
        size -= 1;
        return item_return;
    }
    public Welldone get(int index){
        if(size==0) return null;

        int i = 0;
        StaffNode node_return = sentinel.next;
        while(i<index){
            node_return = node_return.next;
            i += 1;
        }
        return node_return.item;

    }










}
