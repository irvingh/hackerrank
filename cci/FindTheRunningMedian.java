
public class FindTheRunningMedian {
    MinIntHeap upperMinIH = new MinIntHeap();
    MaxIntHeap lowerMaxIH = new MaxIntHeap();

    FindTheRunningMedian() {
        addItem(94455);
        System.out.println(median());
        addItem(20555);
        System.out.println(median());
        addItem(20535);
        System.out.println(median());
        addItem(53125);
        System.out.println(median());
        addItem(73634);
        System.out.println(median());
        addItem(148);
        System.out.println(median());
        addItem(63772);
        System.out.println(median());
        addItem(17738);
        System.out.println(median());
    }

    public void addItem(int item) {
        if (lowerMaxIH.size() == 0) {
            lowerMaxIH.add(item);
        } else if (upperMinIH.size() == 0) {
            if (item < lowerMaxIH.peak()) {
                upperMinIH.add(lowerMaxIH.poll());
                lowerMaxIH.add(item);
            } else
                upperMinIH.add(item);
        } else if (upperMinIH.size() < lowerMaxIH.size()) {
            if (item < lowerMaxIH.peak()) {
                upperMinIH.add(lowerMaxIH.poll());
                lowerMaxIH.add(item);
            } else
                upperMinIH.add(item);
        } else if (upperMinIH.size() == lowerMaxIH.size()) {
            if (item < upperMinIH.peak())
                lowerMaxIH.add(item);
            else {
                lowerMaxIH.add(upperMinIH.poll());
                upperMinIH.add(item);
            }
        }
    }

    double median() {
        if (lowerMaxIH.size() == upperMinIH.size())
            return (double) (lowerMaxIH.peak() + upperMinIH.peak()) / 2;
        return lowerMaxIH.peak();
    }
}
