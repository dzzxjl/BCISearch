 myChart = echarts.init(document.getElementById('main')); 
        
         option = {
    title : {
        text: 'Fine granularity realtions between bio-activities',
        subtext: '',
        x:'right',
        y:'bottom'
    },
    tooltip : {
        trigger: 'item',
        formatter: '{a} : {b}'
    },
    toolbox: {
        show : true,
        feature : {
            restore : {show: true},
            magicType: {show: true, type: ['force', 'chord']},
            saveAsImage : {show: true}
        }
    },
    legend: {
        x: 'left',
        data:['Initiator','Acceptor']
    },
    series : [
        {
            type:'force',
            name : "Relation",
            ribbonType: false,
            categories : [
                {
                    name: 'Disease'
                },
                {
                    name: 'Initiator'
                },
                {
                    name:'Acceptor'
                }
            ],
            itemStyle: {
                normal: {
                    label: {
                        show: true,
                        textStyle: {
                            color: '#333'
                        }
                    },
                    nodeStyle : {
                        brushType : 'both',
                        borderColor : 'rgba(255,215,0,0.4)',
                        borderWidth : 1
                    },
                    linkStyle: {
                        type: 'curve'
                    }
                },
                emphasis: {
                    label: {
                        show: false
                        // textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
                    },
                    nodeStyle : {
                        //r: 30
                    },
                    linkStyle : {}
                }
            },
            useWorker: false,
            minRadius : 15,
            maxRadius : 25,
            gravity: 1.1,
            scaling: 1.1,
            roam: 'move',
            nodes:[
{category:0, name: 'Breast cancer', value : 12,label:'Disease: Breast cancer'},
{category:1, name: 'Six assessments', value : 3},
{category:2, name: 'the effectiveness of low-dose spiral CT', value : 2},
{category:1, name: 'The transcriptional activity of the NANOG gene', value : 3},
{category:2, name: 'an influence on MMP-2', value : 2},
{category:1, name: 'The transcriptional activity of the NANOG gene', value : 3},
{category:2, name: 'MMP-9 expression levels', value : 2},
{category:1, name: 'a TLR4 agonist', value : 3},
{category:2, name: 'antitumor effects in several mammary tumor mouse models', value : 2},
{category:1, name: 'the F-box protein S-phase kinase-associated protein 2', value : 3},
{category:2, name: 'an important role', value : 2},
{category:1, name: 'Hazard ratios', value : 3},
{category:2, name: 'Skp2 expression', value : 2},
{category:1, name: 'Hazard ratios', value : 3},
{category:2, name: 'indicators', value : 2},
{category:1, name: 'Immune cells', value : 3},
{category:2, name: 'a large proportion of these accessory cells', value : 2},
{category:1, name: 'Immune cells', value : 3},
{category:2, name: 'many are known to promote tumor progression', value : 2},
{category:1, name: 'short disease-free interval', value : 3},
{category:2, name: 'receptor', value : 2},
{category:1, name: 'negative prognostic factors associated with shorter survival following surgery', value : 3},
{category:2, name: '"estrogen receptor/progesterone receptor negativity, HER2 negativity,"', value : 2},
{category:1, name: 'negative prognostic factors associated with shorter survival following surgery', value : 3},
{category:2, name: 'a short DFI', value : 2},
{category:1, name: 'Identification of a heterozygous pathogenic variant in STK11 by molecular genetic testing', value : 3},
{category:2, name: 'the diagnosis', value : 2},
{category:1, name: 'Prevention', value : 3},
{category:2, name: 'gynecologic malignancy', value : 2},
{category:1, name: '785 nm laser diode sources', value : 3},
{category:2, name: '2D surfaces maps of total hemoglobin absorption', value : 2},
{category:1, name: 'ICCD camera detectors', value : 3},
{category:2, name: '2D surfaces maps of total hemoglobin absorption', value : 2},
{category:1, name: 'polymorphisms in tumour', value : 3},
{category:2, name: 'factor-related apoptosis-inducing ligand', value : 2},
{category:1, name: 'the minor allele or risk allele genotype TT', value : 3},
{category:2, name: 'a higher percentage', value : 2},
{category:1, name: 'Chronic exposure of epithelial cells to high levels of bone morphogenetic protein 2', value : 3},
{category:2, name: 'stem cell transformation toward a luminal tumor-like phenotype', value : 2},
{category:1, name: 'The heterotypic adherens junctions between cancer cells', value : 3},
{category:2, name: 'the mTOR pathway', value : 2},




               
            ],
            links : [
{source : 'Six assessments', target : 'the effectiveness of low-dose spiral CT', weight : 3, name: 'investigate'},
{source : 'Six assessments', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'the effectiveness of low-dose spiral CT', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'The transcriptional activity of the NANOG gene', target : 'an influence on MMP-2', weight : 3, name: 'has'},
{source : 'The transcriptional activity of the NANOG gene', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'an influence on MMP-2', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'The transcriptional activity of the NANOG gene', target : 'MMP-9 expression levels', weight : 3, name: 'has'},
{source : 'The transcriptional activity of the NANOG gene', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'MMP-9 expression levels', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'a TLR4 agonist', target : 'antitumor effects in several mammary tumor mouse models', weight : 3, name: 'exhibit'},
{source : 'a TLR4 agonist', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'antitumor effects in several mammary tumor mouse models', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'the F-box protein S-phase kinase-associated protein 2', target : 'an important role', weight : 3, name: 'play'},
{source : 'the F-box protein S-phase kinase-associated protein 2', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'an important role', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'Hazard ratios', target : 'Skp2 expression', weight : 3, name: 'clarify'},
{source : 'Hazard ratios', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'Skp2 expression', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'Hazard ratios', target : 'indicators', weight : 3, name: 'clarify'},
{source : 'Hazard ratios', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'indicators', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'Immune cells', target : 'a large proportion of these accessory cells', weight : 3, name: 'make'},
{source : 'Immune cells', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'a large proportion of these accessory cells', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'Immune cells', target : 'many are known to promote tumor progression', weight : 3, name: 'make'},
{source : 'Immune cells', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'many are known to promote tumor progression', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'short disease-free interval', target : 'receptor', weight : 3, name: 'includ'},
{source : 'short disease-free interval', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'receptor', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'negative prognostic factors associated with shorter survival following surgery', target : '"estrogen receptor/progesterone receptor negativity, HER2 negativity,"', weight : 3, name: 'include'},
{source : 'negative prognostic factors associated with shorter survival following surgery', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : '"estrogen receptor/progesterone receptor negativity, HER2 negativity,"', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'negative prognostic factors associated with shorter survival following surgery', target : 'a short DFI', weight : 3, name: 'include'},
{source : 'negative prognostic factors associated with shorter survival following surgery', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'a short DFI', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'Identification of a heterozygous pathogenic variant in STK11 by molecular genetic testing', target : 'the diagnosis', weight : 3, name: 'allow'},
{source : 'Identification of a heterozygous pathogenic variant in STK11 by molecular genetic testing', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'the diagnosis', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'Prevention', target : 'gynecologic malignancy', weight : 3, name: 'prevent'},
{source : 'Prevention', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'gynecologic malignancy', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : '785 nm laser diode sources', target : '2D surfaces maps of total hemoglobin absorption', weight : 3, name: 'generate'},
{source : '785 nm laser diode sources', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : '2D surfaces maps of total hemoglobin absorption', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'ICCD camera detectors', target : '2D surfaces maps of total hemoglobin absorption', weight : 3, name: 'generate'},
{source : 'ICCD camera detectors', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : '2D surfaces maps of total hemoglobin absorption', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'polymorphisms in tumour', target : 'factor-related apoptosis-inducing ligand', weight : 3, name: 'necrosi'},
{source : 'polymorphisms in tumour', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'factor-related apoptosis-inducing ligand', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'the minor allele or risk allele genotype TT', target : 'a higher percentage', weight : 3, name: 'had'},
{source : 'the minor allele or risk allele genotype TT', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'a higher percentage', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'Chronic exposure of epithelial cells to high levels of bone morphogenetic protein 2', target : 'stem cell transformation toward a luminal tumor-like phenotype', weight : 3, name: 'initiate'},
{source : 'Chronic exposure of epithelial cells to high levels of bone morphogenetic protein 2', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'stem cell transformation toward a luminal tumor-like phenotype', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'The heterotypic adherens junctions between cancer cells', target : 'the mTOR pathway', weight : 3, name: 'promote'},
{source : 'The heterotypic adherens junctions between cancer cells', target : 'Breast cancer', weight : 1, name: 'Disease associated'},
{source : 'the mTOR pathway', target : 'Breast cancer', weight : 1, name: 'Disease associated'},


             
            ]
        }
    ]
};
        myChart.setOption(option); 