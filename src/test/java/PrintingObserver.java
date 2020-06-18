import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class PrintingObserver implements Observer<String> {


    @Override
    public void onSubscribe(@NonNull Disposable d) {
        System.out.println("onSubscribe - PrintingObserver");
    }

    @Override
    public void onNext(@NonNull String s) {
        System.out.println("onNext - PrintingObserver: " + s);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        System.out.println("onError - PrintingObserver");
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete - PrintingObserver");
    }
}
