FROM node:lts-alpine as build-stage
WORKDIR /app

COPY . /app
RUN npm install

EXPOSE 4200

CMD ["npm", "run", "start"]