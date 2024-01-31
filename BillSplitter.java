public class BillSplitter {

    public static UniqueOrderedList<Integer> split(UniqueOrderedList<Integer> items, int target) {
        UniqueOrderedList<Integer> result = new UniqueOrderedList<>();
        splitRecursive(items.iterator(), target, result);
        if (items.size() == 0)
            return result;
        if (result.getHead() == null)
            return null;
        return result;
    }

    private static UniqueOrderedList<Integer> splitRecursive(CopyableIterator<Integer> iterator, int target, UniqueOrderedList<Integer> result) {
        if (!iterator.hasNext()) {
            // Base case: No items left
            if (target == 0) {
                // Valid solution found
                return new UniqueOrderedList<>();
            } else {
                // No valid solution
                return null;
            }
        } else {
            int curr = iterator.next();

            // Option 1: Assign the current item to you
            if (curr <= target) {
                UniqueOrderedList<Integer> soln1 = splitRecursive(iterator.copy(), target - curr, result);
                if (soln1 != null) {
                    // If a valid solution is found, add the current item to the result
                    result.add(curr);
                    return soln1;
                }
            }

            // Option 2: Assign the current item to your friend
            UniqueOrderedList<Integer> soln2 = splitRecursive(iterator.copy(), target, result);
            if (soln2 != null) {
                return soln2;
            } else {
                return null;
            }
        }
    }
}
