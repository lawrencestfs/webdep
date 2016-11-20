# webdep
Web Dependability (WebDep)
WebDep (Web Dependability)

Objetivo e Escopo:
O objetivo do software apresentado neste documento é ampliar a visão do nível de confiança dos softwares web em uso nas empresas.

A confiança de sistemas pode ser medida por algumas métricas, dentre elas a disponibilidade, a confiabilidade e o tempo médio entre falhas são de especial interesse. Contudo, na maioria das vezes um administrador de sistemas só sabe que seus sistemas falharam através da abertura de chamados pelo usuário final. Porém, os chamados não são abertos sempre que ocorrem falhas, tornando a medição de confiança baseada em chamados imprecisa.

Grande parte dos sistemas de negócios executam em uma arquitetura cliente/servidor baseada na web. Uma forma de identificar falhas no lado servidor neste tipo de sistema é através do log de acesso do servidor de web, que registra todas as requisições recebidas e seus códigos de retorno HTTP. Em especial o código de retorno HTTP 500 indica um erro interno no servidor, o que na maioria das vezes é um erro de programação do sistema. O Apache é o servidor web mais popular nas empresas, podendo executar uma diversidade de linguagens de programação através de seus plug-ins.

Desta forma, visando aumentar a visibilidade do nível de confiança dos sistemas empresariais, propomos um sistema para medição de confiança de aplicações web utilizando como fonte de informação os logs do servidor web apache.
