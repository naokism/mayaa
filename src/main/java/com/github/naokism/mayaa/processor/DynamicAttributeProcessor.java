package com.github.naokism.mayaa.processor;

import org.seasar.mayaa.engine.Page;
import org.seasar.mayaa.engine.processor.ProcessStatus;
import org.seasar.mayaa.engine.processor.ProcessorProperty;
import org.seasar.mayaa.engine.specification.QName;
import org.seasar.mayaa.impl.engine.specification.SpecificationUtil;

/**
 * Created by naokism on 2014/07/31.
 */
public class DynamicAttributeProcessor extends org.seasar.mayaa.impl.engine.processor.AttributeProcessor {


    private ProcessorProperty _name;
    // MLD property
    public void setName(ProcessorProperty name) {
        if(name == null){
            throw new IllegalArgumentException();
        }
        _name = name;
    }

    @Override
    public ProcessStatus doStartProcess(Page topLevelPage) {

        Object obj = _name.getValue().execute(null);

        if(obj == null){
            throw new IllegalArgumentException();
        }

        QName oQName = SpecificationUtil.createQName(obj.toString());
        setName(SpecificationUtil.createPrefixAwareName(oQName));

        return super.doStartProcess(topLevelPage);
    }
}
