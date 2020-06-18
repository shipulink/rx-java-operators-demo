import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;

public final class ObservableSayHelloOperator extends Observable<String> implements HasUpstreamObservableSource<String> {

    private final ObservableSource<String> source;

    public ObservableSayHelloOperator(ObservableSource<String> source) {
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer<? super String> observer) {
        source.subscribe(new SayHelloObserver(observer));
    }

    @Override
    public ObservableSource<String> source() {
        return source;
    }

}
