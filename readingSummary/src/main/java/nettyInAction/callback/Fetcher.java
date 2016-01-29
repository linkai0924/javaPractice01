package nettyInAction.callback;

public interface Fetcher {
    void fetchData(FetcherCallback callback);
}