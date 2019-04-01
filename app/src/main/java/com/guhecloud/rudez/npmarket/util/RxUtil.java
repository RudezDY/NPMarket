package com.guhecloud.rudez.npmarket.util;



import com.guhecloud.rudez.npmarket.commonmodel.http.ex.ApiException;
import com.guhecloud.rudez.npmarket.commonmodel.http.ex.AuthException;
import com.guhecloud.rudez.npmarket.commonmodel.http.response.ResultMessage;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by codeest on 2016/8/3.
 */
public class RxUtil {

    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    public static <T> FlowableTransformer<ResultMessage<T>, T> handResultMessage() {
        return new FlowableTransformer<ResultMessage<T>, T>() {
            @Override
            public Flowable<T> apply(@NonNull Flowable<ResultMessage<T>> upstream) {
                return upstream.flatMap(new Function<ResultMessage<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(@NonNull ResultMessage<T> tResultMessage) throws Exception {
                        if (ResultMessage.SUCCESS == tResultMessage.getResultCode()) {
                            return createData(tResultMessage.getData());
                        } else if (ResultMessage.AUTH_FAIL == tResultMessage.getResultCode()) {
                            return Flowable.error(new AuthException(tResultMessage.getResultMsg()));
                        } else {
                            return Flowable.error(new ApiException(tResultMessage.getResultMsg()));
                        }
                    }
                });
            }
        };
    }

    public static  FlowableTransformer<ResultMessage, ResultMessage> handlerResultMessage() {
        return new FlowableTransformer<ResultMessage, ResultMessage>() {
            @Override
            public Flowable<ResultMessage> apply(@NonNull Flowable<ResultMessage> upstream) {
                return upstream.flatMap(new Function<ResultMessage, Flowable<ResultMessage>>() {
                    @Override
                    public Flowable<ResultMessage> apply(@NonNull ResultMessage tResultMessage) throws Exception {
//                        if (ResultMessage.SUCCESS == tResultMessage.getResultCode()) {
                            return createData(tResultMessage);
//                        } else if (ResultMessage.AUTH_FAIL == tResultMessage.getResultCode()) {
//                            return Flowable.error(new AuthException(tResultMessage.getResultMsg()));
//                        } else {
//                            return Flowable.error(new ApiException(tResultMessage.getResultMsg()));
//                        }
                    }
                });
            }
        };
    }


//    @android.support.annotation.NonNull
//    public static <ResultType> Function<Flowable<Throwable>, Publisher<ResultType>> retryToken(final UserManager userManager, final RetryPublisher retryPublisher) {
//        return new Function<Flowable<Throwable>, Publisher<ResultType>>() {
//            @Override
//            public Publisher<ResultType> apply(Flowable<Throwable> throwableFlowable) throws Exception {
//
//                return throwableFlowable.flatMap(new Function<Throwable, Publisher<ResultType>>() {
//                    @Override
//                    public Publisher<ResultType> apply(Throwable throwable) throws Exception {
//                        if (throwable instanceof AuthException) {
//                            return userManager.netToken();
//                        } else {
//                            return Flowable.error(throwable);
//                        }
//                    }
//                });
//            }
//        };
//    }


    public interface RetryPublisher<ResultType> {
        Publisher<ResultType> createPublisher(String token);
    }

    /**
     * 生成Flowable
     *
     * @param <T>
     * @return
     */
    public static <T> Flowable<T> createData(final T t) {



        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }


}
