/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fernandocejas.android10.sample.domain.interactor;

import com.fernandocejas.android10.sample.domain.User;
import com.fernandocejas.android10.sample.domain.executor.PostExecutionThread;
import com.fernandocejas.android10.sample.domain.executor.ThreadExecutor;
import com.fernandocejas.android10.sample.domain.giphy.DDataItem;
import com.fernandocejas.android10.sample.domain.repository.DRepository;
import com.fernandocejas.arrow.checks.Preconditions;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link User}.
 */
public class ActionLike extends UseCase<Boolean, ActionLike.Params> {

    private final DRepository userRepository;

    @Inject
    ActionLike(DRepository userRepository, ThreadExecutor threadExecutor,
               PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    Observable<Boolean> buildUseCaseObservable(ActionLike.Params params) {
        Preconditions.checkNotNull(params);
        this.userRepository.onLiked(params.idPost, params.isLike);
        return Observable.just(true);
    }


    public static final class Params {

        private final String idPost;

        private final boolean isLike;

        public Params(String idPost, boolean isLike) {
            this.idPost = idPost;
            this.isLike = isLike;
        }

        public static ActionLike.Params forParam(String idPost, boolean isLike) {
            return new ActionLike.Params(idPost, isLike);
        }
    }
}
