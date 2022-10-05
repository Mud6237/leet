FROM gitpod/workspace-full

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && sdk install java 11.0.11.j9-adpt && sdk install gradle 7.1"
RUN echo "alias leet='./leet.sh ' \n alias grd='./gradlew ' " > ~/.bashrc