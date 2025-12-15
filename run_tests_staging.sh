#!/usr/bin/env bash

BROWSER=$1
ENVIRONMENT=$2
sbt scalafmtAll scalafmtCheckAll scalafmtSbtCheck clean compile -Dbrowser="${BROWSER:=chrome}" -Denvironment="${ENVIRONMENT:=staging}" -Dbrowser.option.headless=true "testOnly uk.gov.hmrc.ui.specs.GiftAidJourneySpec" testReport