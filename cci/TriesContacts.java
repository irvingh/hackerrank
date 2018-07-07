import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TriesContacts {
    class Node {
        HashMap<Character, Node> child = new HashMap<>();
        boolean isEnd = true;
        int cnt = 0;

        void addWord(String w) {
            isEnd = false;
            Character c = w.charAt(0);
            Node n = child.containsKey(c) ? child.get(c) : new Node();
            n.cnt++;
            child.putIfAbsent(c, n);
            if (w.length()>1)
                n.addWord(w.substring(1));
        }

        int getTail(String w) {
            int i = 0;
            Node tailNode = this;
            while (i < w.length()) {
                Character c = w.charAt(i++);
                tailNode = tailNode.child.get(c);
                if (tailNode == null)
                    return 0;
            }
            return tailNode.cnt;
        }
    }
    int countTail(Node n) {
        Collection<Node> col = n.child.values();
        Node[] nArray = col.toArray(new Node[col.size()]);
        int res = 0;
        int len = n.child.size();
        for (int i=0; i<len; i++) {
            res = res + (n.isEnd ? 1 : countTail(nArray[i]));
        }
        return res;
    }

    public void solution() {
        Node dic = new Node();
        dic.addWord("ha");
        dic.addWord("hac");
        System.out.println(dic.getTail("ha"));
        System.out.println(dic.getTail("hi"));
        dic.addWord("co");
        System.out.println(dic.getTail("c"));
    }
}
