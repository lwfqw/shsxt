<#--字符串转get-->
<#macro get str>
   <#if str??>
       get${str?substring(0,1)?upper_case}${str?substring(1)}
       <#else >
          <h2>没有内容</h2>
   </#if>
</#macro>
<#--遍历-->
<#macro forEach items>
    <#if items??>
        <#list items as item>
            ${item}&nbsp;
        </#list>
        <#else >
        <h2>列表为空</h2>
    </#if>
</#macro>
<#macro chose val>
    <#switch val>
        <#case 1>1
        <#case 2>2
        <#case 3>3
        <#case 4>4
        <#case 5>5
        <#default >非1-5
    </#switch>
</#macro>