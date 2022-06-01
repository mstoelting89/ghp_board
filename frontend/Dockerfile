FROM node:10

WORKDIR /usr/src/app/ghp_board_frontend

COPY package*.json ./

RUN npm install

EXPOSE 8081

CMD ["npm", "run", "serve"]