package nettyInAction.callback;


/**
 * Created by xiaokai on 2016/1/29.
 */
public class Worker {

    public static void main(String[] args) {
        Worker w = new Worker();
        w.doWork();
    }

    public void doWork() {
        Fetcher fetcher = new MyFetcher(new Data(1, 1));
        fetcher.fetchData(new FetcherCallback() {

            @Override
            public void onError(Throwable cause) {
                System.out.println("An error accour: " + cause.getMessage());
            }

            @Override
            public void onData(Data data) {
                System.out.println("Data received: " + data);
            }
        });
    }
}

