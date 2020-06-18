import io.reactivex.Observable;
import org.junit.jupiter.api.Test;


class Demo {

    private static final Observable<String> NAMES_OBSERVABLE = Observable.just("Nan", "Charlie", "Yardo");

    // If we were contributing to RxJava, we'd add a method to Observable. Something like:
    //
    //        public Observable<String> sayHello() {
    //            return new ObservableSayHelloOperator(this);
    //        }
    //
    // And then we could do:
    //
    // NAMES_OBSERVABLE.sayHello()...
    //
    // But without changing RxJava source code:
    @Test
    void customOperator_byExtendingObservable() {
        new ObservableSayHelloOperator(NAMES_OBSERVABLE).subscribe(new PrintingObserver());
    }

    @Test
    void customOperator_usingLift() {
        NAMES_OBSERVABLE.lift(new SayHelloOperator()).subscribe(new PrintingObserver());
    }

    @Test
    void phases() {
        Observable<String> observable = Observable
                .fromArray("A", "B", "C")  // Creates ObservableFromArray instance
                .map(s -> s + "+");        // Creates ObservableMap instance

        observable.subscribe();            // Creates a LambdaObserver and kicks off Subscription
    }
}
