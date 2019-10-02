//
// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See LICENSE.md file in the project root for full license information.
//
package com.microsoft.cognitiveservices.speech;

import java.io.Closeable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.Grammar;

/**
 * Represents a ClassLanguageModel.
 *
 * ClassLanguageModels are only usable in specific scenarios and are not generally available.
 *
 * Added in version 1.7.0
 */
public final class ClassLanguageModel extends Grammar implements Closeable 
{
    /**
     * Creates a classLanguageModel from its storage Id.
     * Creating a ClassLanguageModel from a storage ID is only usable in specific scenarios and is not generally available.
     *
     * @param id The Id of the Class Language Model
     * @return classLanguageModel associated with the given Id.
     */
    public static ClassLanguageModel fromStorageId(String id)
    {
        com.microsoft.cognitiveservices.speech.internal.ClassLanguageModel grammarImpl = com.microsoft.cognitiveservices.speech.internal.ClassLanguageModel.FromStorageId(id);
        return new ClassLanguageModel(grammarImpl);
    }

    /**
     * Assigns a grammar to a specified class in a language model.
     * @param className The name of a class in the language model.
     * @param grammar The grammar to associate with the class.
     */
    public void assignClass(String className, Grammar grammar)
    {
        classLanguageModelImpl.AssignClass(className, grammar.getGrammarImpl());
    }

    private com.microsoft.cognitiveservices.speech.internal.ClassLanguageModel classLanguageModelImpl;
    
    private ClassLanguageModel(com.microsoft.cognitiveservices.speech.internal.ClassLanguageModel classLanguageModelImpl)
    {
        super(classLanguageModelImpl);
        Contracts.throwIfNull(classLanguageModelImpl, "ClassLanguageModelInternalImplementation");
        this.classLanguageModelImpl = classLanguageModelImpl;
    }
}