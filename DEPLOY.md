# Deploy

## Install Heroku
[Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli)

## Deploy
### TLDR;
```shell script
heroku git:remote -a wifi-admin
```
Then deploy.

If you want to deploy from master:
```shell script
git push heroku master
```
Not from master:
```shell script
git push heroku your-branch:master
# or
git push heroku +HEAD:master
```
or something similar (see [Deploy non master branches](https://devcenter.heroku.com/articles/git#deploying-code))

And then:
```shell script
heroku open
```
to open the app in browser or just go to [herokuapp](https://wifi-admin.herokuapp.com)
