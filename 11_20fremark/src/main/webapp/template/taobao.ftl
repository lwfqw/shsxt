<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <style type="text/css">
        p{
            text-indent: 2em;
            text-align: justify;
        }
    </style>
</head>
<body>
<h1>${title}</h1>
<div>
    <div style="float: left">
       价格： ${price}&nbsp;销量：${sell}
    </div>
    <div style="float: right">
        发货地： ${city}
    </div>
</div>
<div>
   <p>
       ${content}
   </p>
    <p>
        ${shenming}
    </p>
    <img src="${url}" width="60%"/>
</div>
</body>
</html>