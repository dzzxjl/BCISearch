# BCISearch——Breast Cancer Information Search
BCISeach: A Searching Platform of Breast Cancer Text Mining for Biomedical Literature

### PUBLICATIONS
> Gong L, Yang R, **Yang H**, et al. BCISeach: a searching platform of breast cancer text mining for biomedical literature[C]//Semantics, Knowledge and Grids (SKG), 2016 12th International Conference on. IEEE, 2016: 158-161.

### 主要模块
- 文献在线实体识别
- 实体搜索
- 实体展示
- 语料下载

### Menu
* Home
* Static Information
 * show entity
 * Search For an entity
 * Search by PMID
* Dynamic Information
* Entity Recognition
* Document
* Corpus
* About

### 项目总结
- 了解并学习自然语言处理与数据挖掘相关内容
- 实验数据（生物信息学科论文库NCBI）抓取（JAVA爬虫），特征识别（CRF++），优化模型，实验数据的处理（字符串处理与XML标签化）
- 使用JavaWeb技术搭建一个基于Linux平台的生物医学文本挖掘系统，该系统可从大量文献中挖掘乳腺癌的六类生物信息，包括DNA、RNA、Protein、Cell-type,Cell-line及Virus。数据进行可视化处理（图关系）

### 同类工具
* ppi finder
* poly search

### Doc
* What is Static Information？
 * Show the entity by the entity type
 * Search For an entity(MCF-7)
 * Search by PMID(1000520)
* What is Dynamic Information？
* In this page,you can see the Relationship Graph between the different entity.
* How to use the Entity Recognition?
* Input the text into the text

### 遇到的问题
* 显示问题
 * α，β，γ等网页显示有问题，会显示为？
 * 另外数据库中存在原本就带有？的实体例如p ?/.lt   p ?/.gt，可以删去（要求至少网页上的显示没有问题）
* 重名问题——实体的缩写全称，单复数，有横线无横线
* 显示的protein，dna,rna等数目不对（希望显示的是berminer和abner共同识别的）
* 200000篇文章线性关系的展示
* 文章语法关系的算法

### 其他
* 使用花生壳来进行外网映射
* 

