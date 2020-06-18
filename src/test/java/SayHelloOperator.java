import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;

public class SayHelloOperator implements ObservableOperator<String, String> {
    @NonNull
    @Override
    public Observer<? super String> apply(@NonNull Observer<? super String> observer) {
        return new SayHelloObserver(observer);
    }
}
