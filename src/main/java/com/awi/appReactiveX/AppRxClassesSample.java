package com.awi.appReactiveX;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.java.Log;

import static com.awi.utils.LogUtils.LogAwi;
import static com.awi.utils.LogUtils.LogSeparator;

@Log
public class AppRxClassesSample {

  public static void main(String[] args) {

    Integer[] numbers = {3, 1, 5, 8, 65, 8, 2, 1, 7, 9, 6, 4};

    myObserverSingle()
        .filter(number -> number > 4)
        .subscribeOn(Schedulers.io())
        .subscribe(result -> {
          LogAwi("hilos: " + Thread.activeCount());
          LogAwi(result);
        });

    LogSeparator();

    myObserverCompletable().subscribe();//(() -> LogAwi("Fin  Completable"));
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
}
