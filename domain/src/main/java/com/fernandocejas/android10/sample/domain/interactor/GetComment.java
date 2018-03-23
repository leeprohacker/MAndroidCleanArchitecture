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

import com.fernandocejas.android10.sample.domain.DComment;
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
public class GetComment extends UseCase<java.util.List<DComment>,GetComment.Params> {

    private final DRepository userRepository;

    @Inject
    GetComment(DRepository userRepository, ThreadExecutor threadExecutor,
               PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    Observable<java.util.List<DComment>> buildUseCaseObservable(GetComment.Params params) {
        Preconditions.checkNotNull(params);
        return this.userRepository.getComments(params.idPost);
    }


    public static final class Params {

        private final String idPost;


        private Params(String idPost) {
            this.idPost = idPost;
        }

        public static GetComment.Params forParam(String idPost) {
            return new GetComment.Params(idPost);
        }
    }
}
