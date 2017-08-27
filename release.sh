#!/bin/bash
versionName=$1
oldVersionCode=$(cat ./app/build.gradle | grep versionCode | grep -o  '[0-9]\+')
versionCode=$((oldVersionCode+1))

git add .
git stash

sed -i .back "s/versionName \"[0-9]*.[0-9].[0-9]\"/versionName \"${versionName}\"/g" ./app/build.gradle
rm ./app/build.gradle.back

sed -i .back "s/versionCode [0-9]/versionCode ${versionCode}/g" ./app/build.gradle
rm ./app/build.gradle.back

git add .
git commit -m "Release ${versionName}"
git tag -a ${versionName}

git stash pop
