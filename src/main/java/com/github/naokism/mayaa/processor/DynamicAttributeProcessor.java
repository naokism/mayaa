package com.github.naokism.mayaa.processor;

import org.seasar.mayaa.engine.processor.ProcessorProperty;
import org.seasar.mayaa.engine.specification.QName;
import org.seasar.mayaa.impl.engine.specification.SpecificationUtil;

/**
 * Created by naokism on 2014/07/31.
 */
public class DynamicAttributeProcessor extends org.seasar.mayaa.impl.engine.processor.AttributeProcessor {

    // MLD property
    public void setName(ProcessorProperty name) {
        if(name == null){
            throw new IllegalArgumentException();
        }
        Object obj = name.getValue().execute(null);

        if(obj == null){
            throw new IllegalArgumentException();
        }

        QName oQName = SpecificationUtil.createQName(obj.toString());
        setName(SpecificationUtil.createPrefixAwareName(oQName));

    }

}
