package io.github.chpressler.jmagicmirror.rxjava;

import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<String> sl = Arrays.asList("bla", "blubb", "?", "!") ;
        Observable<String> o = Observable.from(sl);
        o.subscribe(new SimpleObserver());

        sl.stream().filter(s -> s.contains("b")).forEach(System.out::println);

    }
}
