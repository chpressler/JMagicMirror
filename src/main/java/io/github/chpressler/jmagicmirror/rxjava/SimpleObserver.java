package io.github.chpressler.jmagicmirror.rxjava;

import rx.Observer;

public class SimpleObserver implements Observer {

    @Override
    public void onCompleted() {
        System.out.println("complete ... ");
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("error ... " + throwable.toString());
    }

    @Override
    public void onNext(Object o) {
        System.out.println("next ... " + o);
    }

}
