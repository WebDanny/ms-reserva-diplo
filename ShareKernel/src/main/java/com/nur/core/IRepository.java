package com.nur.core;

import java.util.concurrent.CompletableFuture;

public interface IRepository <T extends AggregateRoot, TId>{
    CompletableFuture<T> findById(TId id);
    CompletableFuture<Void> createAsync(T obj);
}
