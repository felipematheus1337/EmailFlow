# 📧 EmailFlow

Sistema de envio de e-mails em massa com foco em **resiliência**, **observabilidade** e **registro detalhado de eventos**.

---

## 🔍 Visão Geral

O **EmailFlow** é uma aplicação Java com Spring Boot desenvolvida para demonstrar práticas modernas de backend como:

- Envio assíncrono de e-mails com **Apache Kafka**
- Tratamento de falhas com **Resilience4j** (retry, fallback e circuit breaker)
- Retentativas com @Scheduled
- Observabilidade com **Prometheus** e **Grafana**
- Persistência de logs e histórico no **SQL Server**
- Armazenamento de mensagens enviadas no **MongoDB**, via **Spring HTTP Client**
- Logging estruturado com MDC e integração com ferramentas de análise

---

## 🛠️ Tecnologias Utilizadas

- Java 21+
- Docker
- Spring Boot
- Spring Web
- Spring Data JPA + SQL Server
- Spring Retry + Resilience4j
- Spring Kafka
- Spring Actuator + Prometheus
- Grafana
- MongoDB (via outro monolito com REST API)
- HTTP Client
- Logback + MDC (Logging estruturado)

---

## ⚙️ Arquitetura Geral

O sistema é dividido em **dois monolitos**:

### 🔸 Monolito Principal (EmailFlow)
- Recebe requisições de envio de e-mail
- Envia mensagens para o Kafka
- Processa os consumidores com retry e fallback
- Salva logs no SQL Server
- Após envio com sucesso, envia dados para o segundo monolito

### 🔹 Monolito Auxiliar (EmailStorage)
- Recebe mensagens via HTTP
- Salva detalhes da mensagem no MongoDB

### Diagrama de sistema:

<img src="https://github.com/felipematheus1337/EmailFlow/blob/dev/diagram.png?raw=true"/>

---

## 🧪 Exemplos de Conceitos Aplicados

- **Retry automático** no envio de e-mails
- **Fallback**: mensagens não enviadas vão para fila de reenvio manual
- **Circuit Breaker** em caso de falha contínua
- **Tempo de resposta monitorado via Prometheus**
- **Logs com contexto completo (ID da mensagem, tempo, destino, status)**

---

## 🚀 Como Executar

1. Suba os containers do MongoDB, SQL Server, Kafka, Prometheus e Grafana (use o `docker-compose.yml`)
2. Inicie o monolito `EmailFlow`
3. Inicie o monolito `EmailStorage`
4. Acesse a rota de envio de e-mails e verifique os logs e monitoramento

---

## 📊 Dashboards e Monitoramento

- Endpoints do Actuator exportados para Prometheus
- Dashboards configuráveis no Grafana
- Visualização de tentativas, falhas, tempos de resposta e sucesso

