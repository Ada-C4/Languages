module PlanetExpress
  class Game
    attr_accessor: :bender, :fry, :hermes, :leela, :zoidberg

    def initialize
      @bender = Bender.new
      @fry = Fry.new
      @hermes = Hermes.new
      @leela = Leela.new
      @zoidberg = Zoidberg.new
    end
