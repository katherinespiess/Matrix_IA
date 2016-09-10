jQuery(document).ready(function(e){
    $('div.pre_applescript pre').attr('class', 'brush: applescript; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_as3 pre').attr('class', 'brush: as3; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_bash pre').attr('class', 'brush: bash; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_coldfusion pre').attr('class', 'brush: coldfusion; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_cpp pre').attr('class', 'brush: cpp; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_csharp pre').attr('class', 'brush: csharp; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_css pre').attr('class', 'brush: css; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_delphi pre').attr('class', 'brush: delphi; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_diff pre').attr('class', 'brush: diff; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_erland pre').attr('class', 'brush: erland; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_goovy pre').attr('class', 'brush: goovy; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_java pre').attr('class', 'brush: java; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_javafx pre').attr('class', 'brush: javafx; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_js pre').attr('class', 'brush: js; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_perl pre').attr('class', 'brush: perl; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_php pre').attr('class', 'brush: php; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_plain pre').attr('class', 'brush: plain; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_powershell pre').attr('class', 'brush: powershell; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_python pre').attr('class', 'brush: python; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_ruby pre').attr('class', 'brush: ruby; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_saas pre').attr('class', 'brush: saas; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_scala pre').attr('class', 'brush: scala; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_sql pre').attr('class', 'brush: sql; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_vb pre').attr('class', 'brush: vb; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  
    $('div.pre_xml pre').attr('class', 'brush: xml; ruler: true; toolbar: false; gutter: false; smart-tabs: true; tab-size: 4');  

    SyntaxHighlighter.autoloader(
        ['applescript', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushAppleScript.js'],
        ['as3', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushAS3.js'],
        ['bash', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushBash.js'],
        ['coldfusion', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushColdFusion.js'],
        ['cpp', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushCpp.js'],
        ['csharp', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushCSharp.js'],
        ['css', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushCss.js'],
        ['delphi', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushDelphi.js'],
        ['diff', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushDiff.js'],
        ['erland', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushErlang.js'],
        ['goovy', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushGroovy.js'],
        ['java', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushJava.js'],
        ['javafx', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushJavaFX.js'],
        ['js', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushJScript.js'],
        ['perl', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushPerl.js'],
        ['php', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushPhp.js'],
        ['plain', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushPlain.js'],
        ['powershell', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushPowerShell.js'],
        ['python', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushPython.js'],
        ['ruby', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushRuby.js'],
        ['saas', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushSass.js'],
        ['scala', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushScala.js'],
        ['sql', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushSql.js'],
        ['vb', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushVb.js'],
        ['xml', 'http://www.devmedia.com.br/js/2013/syntaxhighlighter/3.0.83/scripts/shBrushXml.js']
    );

    SyntaxHighlighter.all();    
});