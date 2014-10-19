package lv.nikolay.syncasync;

class AsyncEven implements Even{
    private int n = 0;

    public int next() {
        // POST CONDITION: next is always even
        ++n;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ++n;
        return n;
    }
}
