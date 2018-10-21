package com.awi.appReactiveX;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.java.Log;

import static com.awi.utils.LogUtils.LogAwi;
import static com.awi.utils.LogUtils.LogSeparator;

@Log
public class AppRxClassesSample {

  public static void main(String[] args) throws InterruptedException {


    //=====================================

    LogSeparator("Single");

    myObserverSingle()
        .filter(number -> number > 4)
//        .subscribeOn(Schedulers.io())
        .subscribe(result -> {
          LogAwi("hilos: " + Thread.activeCount());
          LogAwi("Resultado Single : " + result);
        });

    //=====================================

    LogSeparator("Completable");

    myObserverCompletable().subscribe(() -> LogAwi("Fin Completable"));//(() -> LogAwi("Fin  Completable"));

    //=====================================

    LogSeparator("Observable");

    myObservable()
        .subscribeOn(Schedulers.io())
        .subscribe(integer -> LogAwi("Observable result: " + integer));

    //=====================================

    Thread.sleep(3000);  //Si no equitas al thread responde rapido e ignora los otros hilos
    LogAwi("FinMainMethod");
  }

  private static Single<Integer> myObserverSingle() {

    Single<Integer> myObservable = Single.create(singleEmitter -> {
      for (int i = 0; i < 5; i++) {
        LogAwi(String.valueOf(i));
        singleEmitter.onSuccess(i + 10);
      }
    });
    return myObservable;
  }

  private static Completable myObserverCompletable() {

    Completable completable = Completable.create(completableEmitter -> {
      for (int i = 0; i < 5; i++) {
        LogAwi(String.valueOf(i));
      }
      completableEmitter.onComplete();
    });
    return completable;
  }

  private static Observable<Integer> myObservable() {

    Observable<Integer> myObservable = Observable.create(observableEmitter -> {
      for (int i = 0; i < 5; i++) {
//        LogAwi(String.valueOf(i));
        observableEmitter.onNext(i);
      }
    });
    return myObservable;
  }
}
