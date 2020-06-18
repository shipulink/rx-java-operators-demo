import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class SayHelloObserver implements Observer<String> {

    private final Observer<? super String> downstream;

    public SayHelloObserver(Observer<? super String> downstream) {
        this.downstream = downstream;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        downstream.onSubscribe(d);
    }

    @Override
    public void onNext(@NonNull String s) {
        downstream.onNext(String.format("Hello, %s!", s));
    }

    @Override
    public void onError(@NonNull Throwable e) {
        downstream.onError(e);
    }

    @Override
    public void onComplete() {
        downstream.onComplete();
    }
}
