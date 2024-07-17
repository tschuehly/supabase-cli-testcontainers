FROM alpine:latest
WORKDIR /app
RUN wget https://github.com/supabase/cli/releases/download/v1.183.5/supabase_1.183.5_linux_amd64.apk
RUN    apk add --no-cache --allow-untrusted supabase_1.183.5_linux_amd64.apk
RUN    rm supabase_1.183.5_linux_amd64.apk